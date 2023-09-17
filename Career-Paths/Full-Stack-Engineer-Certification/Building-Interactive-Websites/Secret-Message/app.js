let secretMessage = ['Learning', 'is', 'not', 'about', 'what', 'you', 'get', 'easily', 'the', 'first', 'time,', 'it', 'is', 'about', 'what', 'you', 'can', 'figure', 'out.', '-2015,', 'Chris', 'Pine,', 'Learn', 'JavaScript'];
console.log(secretMessage.length)
secretMessage.pop()
console.log(secretMessage.length)
secretMessage.push("to", "Program")
console.log(secretMessage.indexOf('easily'))
secretMessage[7] = "right"
secretMessage.shift()
secretMessage.unshift('Programming')
console.log(secretMessage.indexOf('get'))
console.log(secretMessage.indexOf('time,'))
secretMessage.splice(6, 5, 'know,')
console.log(secretMessage.join(' '))