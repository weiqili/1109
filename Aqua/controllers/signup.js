var readysignup = function (ctx, next) {
    ctx.response.body =
        `</h1>Sign Up</h1>
            <form action="/sign_up" method="post">
                <table>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>CheckCode: </td>
                        <td><input type="text" name="checkcode"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="text-align: right"><input type="submit" value="sign up"></td>
                    </tr>
                </table>
            </form>`;
};

var fn_sign_up = function (ctx, next) {
    // some db operations.
};


module.exports = {
    'GET /readysignup': readysignup,
    'POST /sign_up': fn_sign_up
};