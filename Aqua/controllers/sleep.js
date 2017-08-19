var sleep = function (ctx, next) {
    ctx.response.body = '<h1>sleep sleep sleep</h1>';
}

module.exports = {
    'GET /sleep': sleep
};