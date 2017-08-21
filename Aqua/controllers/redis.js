var Redis = require('ioredis');
var redis = new Redis();

var fn_put = async function(ctx, next){
  let result = await redis.set(ctx.params.key, ctx.params.value);
  ctx.response.body = result;
}


var fn_get = async function(ctx, next){
  let result = await redis.get(ctx.params.key);
  ctx.response.body = result;
}

module.exports = {
  'GET /put/:key/:value': fn_put,
  'GET /get/:key': fn_get
}
