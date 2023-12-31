function setup() {
    createCanvas(500,500)
    line(width/2,0,width/2, height)
    line(0, height/2, width, height/2)
  }
  
  function draw() {
    // Top Left
    stroke(127)
    strokeWeight(10)
    for (let posX = 0; posX < 10; posX++) {
      line(posX * 25, 0, posX * 25, 250)
    }
    // Top Right
    noStroke()
    fill('#ffd700')
    for (let posX = 0; posX < 10; posX++) {
      for (let posY = 0; posY < 10; posY++) {
        if (posX % 2 === 0){
          circle(posX * 25 + width / 2, posY * 25 + 10, 10)
        } else {
          circle(posX * 25 + width / 2, posY * 25, 10)
        }
      }
    }
    // Bottom Left
    fill('red')
    for (let posX = 0; posX < 10; posX++) {
      for (let posY = 0; posY < 10; posY++) {
        if (posX % 2 === 0) {
          square(posX * 25, posY * 50 + height/2 + 25, 25)
        } else {
          square(posX * 25, posY * 50 + height/2, 25)
        }
      }
    }
    // Bottom Right
    strokeWeight(10)
    stroke(0,0,255)
    for (let i = 0; i < 10; i++) {
      line(width/2, height - i * 25, width/2 + i * 25, height)
      line(width/2 + i * 25, height/2, width, height - i * 25)
    }
    stroke(0)
    // Border
    line(width/2, 0, width/2, height)
    line(0, height/2, width, height/2)
    line(0, 0, width, 0)
    line(0, height, width, height)
    line(0, 0, 0, height)
    line(width, 0, width, height)
  
  }
  