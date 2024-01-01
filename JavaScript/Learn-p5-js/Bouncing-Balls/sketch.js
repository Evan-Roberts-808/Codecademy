let ballCount = 250;
let x = [];
let y = [];
let xSpeed = [];
let ySpeed = [];
let size = [];
let r = [];
let g = [];
let b = [];

function setup() {
  createCanvas(windowWidth, windowHeight);

  for (let i = 0; i < ballCount; i++) {
    x[i] = width / 2;
    y[i] = height / 2;
    xSpeed[i] = random(-5, 5);
    ySpeed[i] = random(-5, 5);
    size[i] = random(10, 50);
    r[i] = random(0, 256);
    g[i] = random(0, 256);
    b[i] = random(0, 256);
  }
}

function draw() {
  background(0, 50);
  for (let j = 0; j < ballCount; j++) {
    x[j] += xSpeed[j];
    y[j] += ySpeed[j];
    if (x[j] < 0 || x[j] > width) {
      xSpeed[j] *= -1;
    } else if (y[j] < 0 || y[j] > height) {
      ySpeed[j] *= -1;
    }
    fill(r[j], g[j], b[j]);
    noStroke();
    ellipse(x[j], y[j], size[j], size[j]);
  }
}
