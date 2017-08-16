const Koa = require('koa');
const bodyParser = require('koa-bodyparser');
const scanner = require('./scanner');
const app = new Koa();



//log
app.use(async (ctx, next) => {
    console.log(`${ctx.request.method} ${ctx.request.url}`);
    await next();
});

app.use(async (ctx, next) => {
    const start = new Date().getTime();
    await next();
    const ms = new Date().getTime() - start;
    console.log(`Time: ${ms}ms`);
});


app.use(bodyParser());

app.use(scanner());

app.listen(3000);
