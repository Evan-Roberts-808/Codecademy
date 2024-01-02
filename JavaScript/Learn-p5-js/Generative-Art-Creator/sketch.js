let x, y;
let speedX, speedY;
let redVal, greenVal, blueVal;
let alphaVal = 70;
let angle = 0;

function setup() {
  createCanvas(windowWidth, windowHeight)
  background(50)
  x = random(0, width)
  y = random(0, height)
  speedX = random(-3, 3)
  speedY = random(-3, 3)
}

function draw() {
  if(keyIsPressed === true && key != ' ') {
    if(keyCode % 5 === 0) {
      parametricLines()
    } else if (keyCode % 5 === 1) {
      bouncingEllipse(random(-100, 50))
    } else if (keyCode % 5 === 2) {
      flower()
    }
  }
}

function keyReleased() {
  x = random(0, width)
  y = random(0, height)
  speedX = random(-3, 3)
  speedY = random(-3, 3)
}

function keyPressed() {
  if (key !== ' ') {
    if (keyCode % 5 === 3) {
      roundedRect()
    } else if (keyCode % 5 === 4) {
      star(random(30, 51), random(4, 8))
    } else if (keyCode === 13) {
      saveCanvas('canvas-' + frameCount, 'jpg')
    } 
    } else {
      clear()
      background(50)
  }
}
