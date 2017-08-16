const router = require('koa-router')();
var fs = require('fs');

function scan() {
  //read files
  var files = fs.readdirSync(__dirname + '/controllers');
  //filter js files
  var js_files = files.filter((f)=>{
      return f.endsWith('.js');
  });
  for (var f of js_files) {
    let mapping = require(__dirname + '/controllers/' + f);
    for (var url in mapping) {
      if (url.startsWith('GET')) {
        var path = url.substring(4);
        router.get(path, mapping[url]);
        console.log(`register URL mapping: GET ${path}`);
      } else if(url.startsWith('POST')) {
        var path = url.substring(5);
        router.post(path, mapping[url]);
        console.log(`register URL mapping: POST ${path}`);
      } else {
        console.log(`invalid URL: ${url}`);
      }
    }
  }
  return router.routes();
}


module.exports = scan;
