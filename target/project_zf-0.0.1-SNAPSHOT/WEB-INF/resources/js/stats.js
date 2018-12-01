// onload function, so Lato loads before the program starts
onload = main;
function main() {
    // Define player object and statistics
    var player = {};
    player.life = 61;
    player.defense = 45;
    player.agility = 33;
    player.intellect = 69;
    player.power = 42;
    // Array that takes information from the player object to get the order
    // in which stats are displayed onscreen. Change the order in which
    // the player stats are defined to change order.
    var statOrder = [];
    for (var i in player)
        statOrder.push(i);
    // Define colors. I used simple three-digit hex colors, in this case.
    var statColors = {};
    statColors.life = "#339933";
    statColors.defense = "#333399";
    statColors.agility = "#999933";
    statColors.intellect = "#993399";
    statColors.power = "#993333";

    // Define pentagon (or other polygon) size and coordinates.
    var polygonX = 240;
    var polygonY = 240;
    var polygonSize = 120;
    // Define size of circles.
    var circleSize = 56;
    var circles = [];
    var circleIndexes = [];
    for (var i in statColors)
        circleIndexes.push({defaultColor: statColors[i], color: statColors[i], over: false});

    var innerPolygonColor = statColors.life;
    var innerPolygonKnobs = [];
    for (var i in statColors)
        innerPolygonKnobs.push({over: false, dragging: false});

    // Function for adding elements to screen. Code is reusable.
    function appendElement(type, properties, parent) {
        if (parent === undefined)
            parent = document.body;
        var element = document.createElement(type);
        for (var i in properties) {
            element.setAttribute(i, properties[i]);
        }
        parent.appendChild(element);
        return element;
    }
    // Place canvas object centered in the screen.
    var canvas = appendElement("canvas", {
        width: "480",
        height: "480",
        class: "absolute-center",
    });
    // Get canvas context.
    var ctx = canvas.getContext("2d");

    String.prototype.toRGB = function () {
        var obj;
        var triplet = this.slice(1, this.length);
        var colors = [];
        var index = 0;
        for (var i = 0; i < triplet.length; i += 2) {
            colors[index] = parseInt("0x" + triplet[i] + triplet[i + 1]);
            index++;
        }
        obj = {
            string: "rgb(" + colors[0] + ", " + colors[1] + ", " + colors[2] + ")",
            red: colors[0],
            green: colors[1],
            blue: colors[2],
        };
        return obj;
    }

    function MouseHandler() {
        var handler = this;
        this.x = 0;
        this.y = 0;
        this.down = false;
        this.clicked = false;
        this.move = function (e) {
            handler.x = e.clientX - canvas.getBoundingClientRect().left;
            handler.y = e.clientY - canvas.getBoundingClientRect().top;
        }
        this.click = function (e) {
            handler.down = true;
            handler.clicked = true;
        }
        this.release = function (e) {
            handler.down = false;
        }
        this.over = function (element) {
            var rect = element.getBoundingClientRect();
            return this.x < rect.right && this.x > rect.left && this.y < rect.bottom && this.y > rect.top;
        }
        document.onmousemove = this.move;
        document.onmousedown = this.click;
        document.onmouseup = this.release;
    }
    var vertices = [];
    function drawRegularPolygon(x, y, fill, stroke, strokeWidth, sides, radius) {
        // Draws a regular polygon onto the canvas.
        // Note that a circle can be made by setting sides to radius/2.

        // Variable declarations
        var arc;
        var x;
        var y;
        var point;
        var points = [];

        // Begin drawing with parameters
        ctx.beginPath();
        ctx.fillStyle = fill;
        ctx.strokeStyle = stroke;
        ctx.lineWidth = strokeWidth;
        // Add round line joints
        ctx.lineJoin = 'round';
        // Using sides+1 because the sides should be linked properly.
        for (var i = 0; i <= sides + 1; i++) {
            // Create arc variable
            arc = i * 2 * Math.PI / sides;
            // Add coordinates to array for reuse
            point = {};
            point.x = x + radius * Math.sin(arc);
            point.y = y - radius * Math.cos(arc);
            if (i === 0)
                ctx.moveTo(point.x, point.y);
            else
                ctx.lineTo(point.x, point.y);
            // Prevent point duplication
            if (i < sides + 1)
                points.push(point);
        }
        // Draw polygon
        ctx.fill();
        ctx.stroke();
        // Close path, just in case
        ctx.closePath();
        // Return points array for future use
        return points;
    }
    var circles = [];
    function redraw() {
        circles = [];
        // Fill canvas with black.
        ctx.rect(0, 0, canvas.width, canvas.height);
        ctx.fillStyle = "#000";
        ctx.fill();

        var polygon = drawRegularPolygon(polygonX, polygonY, "#666", "#333", 2, statOrder.length, polygonSize);
        ctx.beginPath();
        ctx.setLineDash([5]);
        ctx.lineDashOffset = 10;
        ctx.strokeStyle = "#333";
        for (var i = 0; i < polygon.length; i++) {
            ctx.moveTo(polygonX, polygonY);
            ctx.lineTo(polygon[i].x, polygon[i].y);
        }
        ctx.stroke();
        // Remove line dash for future use
        ctx.setLineDash([0]);

        // Inner polygon
        ctx.beginPath();
        var index;
        var stat;
        var text;
        var innerPolygonVertices = [];
        var distX;
        var distY;
        var distTotal;
        var x;
        var y;
        for (var i = 0; i < statOrder.length + 1; i++) {
            index = i % statOrder.length;
            if (vertices[index] === undefined)
                vertices[index] = {};
            if (innerPolygonVertices[index] === undefined)
                innerPolygonVertices[index] = {};
            vertices[index].x = polygon[index].x;
            vertices[index].y = polygon[index].y;
            stat = player[statOrder[index]];
            vertices[index].distX = distX = vertices[index].x - polygonX;
            vertices[index].distY = distY = vertices[index].y - polygonY;
            vertices[index].distTotal = Math.sqrt(distX * distX + distY * distY);
            vertices[index].radians = Math.atan2(distY, distX);
            x = polygonX + Math.cos(vertices[index].radians) * (vertices[index].distTotal * stat / 100);
            y = polygonY + Math.sin(vertices[index].radians) * (vertices[index].distTotal * stat / 100);
            innerPolygonVertices[index].x = x;
            innerPolygonVertices[index].y = y;
            ctx.lineTo(x, y);
        }
        // Set alpha of polygon
        ctx.globalAlpha = 0.5;
        ctx.fillStyle = innerPolygonColor;
        ctx.fill();

        ctx.globalAlpha = 1;
        ctx.strokeStyle = innerPolygonColor;
        ctx.stroke();

        for (var i = 0; i < innerPolygonVertices.length; i++) {
            x = innerPolygonVertices[i].x;
            y = innerPolygonVertices[i].y;
            innerPolygonKnobs[i].x = x;
            innerPolygonKnobs[i].y = y;
            if (innerPolygonKnobs[i].over || innerPolygonKnobs[i].dragging) {
                ctx.beginPath();
                ctx.arc(x, y, 8, 0, 2 * Math.PI, false);
                ctx.strokeStyle = statColors[statOrder[index]];
                ctx.stroke();
                ctx.closePath();
            }
        }

        // Draw circles;
        for (var i = 0; i < statOrder.length; i++) {
            index = i;
            x = vertices[index].x + Math.cos(vertices[index].radians) * (circleSize + 8);
            y = vertices[index].y + Math.sin(vertices[index].radians) * (circleSize + 8);
            ctx.beginPath();
            ctx.arc(x, y, circleSize, 0, 2 * Math.PI, false);
            ctx.fillStyle = '#333';
            ctx.fill();
            ctx.closePath();
            ctx.beginPath();
            ctx.arc(x, y, circleSize - 4, 0, 2 * Math.PI, false);
            ctx.fillStyle = "#fff";
            if (circleIndexes[index].over)
                ctx.fillStyle = statColors[statOrder[index]];
            ctx.fill();
            ctx.closePath();
            ctx.beginPath();
            ctx.arc(x, y, circleSize - 6, 0, 2 * Math.PI, false);
            ctx.fillStyle = statColors[statOrder[index]];
            if (circleIndexes[index].over)
                ctx.fillStyle = "#fff";
            ctx.fill();
            ctx.closePath();
            circles.push({x: x, y: y, size: circleSize - 6, radius: (circleSize - 6) / 2, stat: statOrder[index], color: statColors[statOrder[index]]});
            ctx.fillStyle = "#fff";
            if (circleIndexes[index].over)
                ctx.fillStyle = statColors[statOrder[index]];
            ctx.font = "16px Lato";
            text = statOrder[index].toUpperCase();
            stat = player[statOrder[index]] + "%";
            ctx.fillText(text, x - ctx.measureText(text).width / 2, y);
            ctx.fillText(stat, x - ctx.measureText(stat).width / 2, y + 16);
        }
    }
    redraw();
    function getClosestPointOnLine(line, x, y) {
        lerp = function (a, b, x) {
            return(a + x * (b - a));
        };
        var dx = line.x1 - line.x0;
        var dy = line.y1 - line.y0;
        var t = ((x - line.x0) * dx + (y - line.y0) * dy) / (dx * dx + dy * dy);
        t = Math.min(1, Math.max(0, t));
        var lineX = lerp(line.x0, line.x1, t);
        var lineY = lerp(line.y0, line.y1, t);
        return({x: lineX, y: lineY});
    }
    ;
    function pythagorean(dx, dy) {
        return Math.sqrt(dx * dx + dy * dy);
    }
    var fps = 60;
    var circle;
    var mouse = new MouseHandler();
    var oldColor;
    var newColor;
    var transitioning = false;
    var transitionIndex = 0;
    var transitionSteps = 10;
    var red, green, blue, redDiff, greenDiff, blueDiff, redSpeed, greenSpeed, blueSpeed;
    var change;
    function loop() {
        change = false;
        for (var i = 0; i < circles.length; i++) {
            var circle = circles[i];
            distX = circle.x - mouse.x;
            distY = circle.y - mouse.y;
            distTotal = Math.sqrt(distX * distX + distY * distY);
            if (distTotal < circle.size) {
                if (!circleIndexes[i].over)
                    change = true;
                circleIndexes[i].over = true;
                /*        if(!transitioning || circle.color !== newColor){
                 oldColor = innerPolygonColor.toRGB();
                 newColor = circle.color.toRGB();
                 transitioning = true;
                 transitionIndex = 0;
                 red = oldColor.red;
                 green = oldColor.green;
                 blue = oldColor.blue;
                 
                 redDiff = newColor.red-oldColor.red;
                 greenDiff = newColor.green-oldColor.green;
                 blueDiff = newColor.blue-oldColor.blue;
                 redSpeed = redDiff/transitionSteps;
                 greenSpeed = greenDiff/transitionSteps;
                 blueSpeed = blueDiff/transitionSteps;
                 }*/
            } else {
                if (circleIndexes[i].over)
                    change = true;
                circleIndexes[i].over = false;
            }
        }
        for (var i = 0; i < innerPolygonKnobs.length; i++) {
            var knob = innerPolygonKnobs[i];
            distX = knob.x - mouse.x;
            distY = knob.y - mouse.y;
            distTotal = pythagorean(distX, distY);
            if (distTotal < 8) {
                if (!knob.over)
                    change = true;
                knob.over = true;
            } else {
                if (knob.over)
                    change = true;
                knob.over = false;
            }
            if (!mouse.down)
                knob.dragging = false;
            if (mouse.down && knob.over || knob.dragging) {
                for (var j = 0; j < innerPolygonKnobs.length; j ++)
                    innerPolygonKnobs[j].dragging = false;
                knob.dragging = true;
                var line = {x0: polygonX, y0: polygonY, x1: vertices[i].x, y1: vertices[i].y};
                var point = getClosestPointOnLine(line, mouse.x, mouse.y);
                var distStart = pythagorean(point.x - polygonX, point.y - polygonY);
                var distStartEnd = pythagorean(vertices[i].x - polygonX, vertices[i].y - polygonY);
                var percent = distStart / distStartEnd;
                player[statOrder[i]] = Math.round(percent * 100);
                change = true;
            }
        }
        if (transitioning) {
            red += redSpeed;
            green += greenSpeed;
            blue += blueSpeed;
            innerPolygonColor = "#" + Math.round(red).toString(16) + Math.round(green).toString(16) + Math.round(blue).toString(16);
            if (++transitionIndex >= transitionSteps) {
                transitioning = false;
            }
            change = true;
        }
        if (change)
            redraw();
        setTimeout(loop, 1000 / fps);
    }
    setTimeout(loop, 1000 / fps);
}