window.onload = function () {
    createCode(5);
}
var checkCode = document.querySelector(".vcode");
checkCode.onclick = function () {
    createCode(5);
}
//生成验证码
function createCode(length) {
    var code = "";
    var codeLength = parseInt(length);
    var checkCode = document.querySelector(".vcode");

    var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (var i = 0; i < codeLength; i++) {
        //获取随机验证码下标
        var charNum = Math.floor(Math.random() * 62);
        //组合成指定字符验证码
        code += codeChars[charNum];
    }
    if (checkCode) {
        //将生成验证码赋值到显示区
        checkCode.innerHTML = code;
    }
}
