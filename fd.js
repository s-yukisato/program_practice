process.stdin.resume();
process.stdin.setEncoding('utf8');
var lines = [];
var reader = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});
reader.on('line', (line) => {
  lines.push(line);
});
reader.on('close', () => {
    var line = lines[0]
    var map = {}
    var max = 1
    for(i=0; i<4; i++) {
        var c = line[i]
        if(c in map){
            map[c] += 1
            max = Math.max(max, map[c])
        }else{
            map[c] = 1
        }
    }
    var kind = Object.keys(map).length
    
    if ("*" in map) {
        kind -= 1
        max += 1
    }
    if(max == 4) {
        console.log("FourCard")
    } else if(max == 3) {
        console.log("ThreeCard")
    } else if(max == 2 && kind == 2) {
        console.log("TwoPair")
    } else if (max == 2) {
        console.log("OnePair")
    } else {
        console.log("NoPair")
    }
});
