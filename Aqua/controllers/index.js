var p_sign_in = function(ctx, next){
  ctx.response.body = '</h1>Sign in</h1><form action="/sign_in" method="post"><p>Name: <input name="name" value="koa"></p><p>Password: <input name="password" type="password"></p><p><input type="submit" value="Submit"></p></form>';
}

var fn_sign_in = function(ctx, next){
  var name = ctx.request.body.name || '',
      password = ctx.request.body.name || '';
      console.log(`signin with name: ${name}, password: ${password}`);
      if (name === 'koa' && password === '12345') {
          ctx.response.body = `<h1>Welcome, ${name}!</h1>`;
      } else {
          ctx.response.body = `<h1>Login failed!</h1><p><a href="/">Try again</a></p>`;
      }
}

module.exports = {
    'GET /': p_sign_in,
    'POST /sign_in': fn_sign_in
};
