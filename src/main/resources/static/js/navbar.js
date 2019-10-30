$(document).ready(function () {
    $("#loginModal").keydown(function () {
        if (event.keyCode == 13) {
            $("#login").click();
        }
    })

    var user_data = JSON.parse(window.sessionStorage.getItem("data"));

    var userid;
    $("#openLoginModel").css("display", "block");
    if (user_data != null) {
        $("#openLoginModel").css("display", "none");
        var object = user_data.object;
        userid = object.id;
        $("#username").html(object.nikename);
        //登出
        $("#loginOut").click(function () {
            $.ajax({
                url: "/user/loginout",
                type: "POST",
                data: "id=" + object.id,
                success: function (data) {
                    console.log(data.code + "," + data.msg)
                    if (data.code == 200) {
                        window.sessionStorage.clear();
                        $("#openLoginModel").css("display", "none");
                        window.location = "index.html";

                    }

                }
            })
        })
    }

    //登录
    $("#login").click(function () {
        var account = $("#account").val();
        var password = $("#password").val();
        var data = {
            "account": account,
            "password": hex_md5(password)
        };
        if (account == "") {
            $("#msg").html("请输入用户名");
            return;
        }
        $.ajax({
            url: "/user/login",
            type: "post",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                console.log("请求成功" + data.code + "," + data.msg)
                if (data.code != 200) {
                    $(".msg").html(data.msg);
                    return;
                }
                if (data.code == 200) {
                    // console.log(data)
                    var object = data.object;
                    $("#username").html(object.nikename);
                    $("#openLoginModel").css("display", "none");
                    $("#closeModel").click();
                    window.sessionStorage.setItem("data", JSON.stringify(data));
                    window.location = "index.html";
                }
            }
        })




    })
    //检查用户名是否可用
    $("#registeraccount").blur(function () {

        var registeraccount = $("#registeraccount").val();
        console.log(registeraccount);

        var data;


        if (registeraccount != "") {
            data = {
                "registeraccount": registeraccount
            };
        }
        $.ajax({
            type: "POST",
            url: "/user/checkAccount",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),

            success: function (data) {
                console.log("请求成功" + data.code + "," + data.msg)
                if (data.code != 200) {

                    $(".msg").html(data.msg);
                    return;
                }
                if (data.code == 200) {

                    $(".msg").html(data.msg);
                }

            },
            error: function (data) {
                console.log("错误")
            }
        })


    });
    $("#register").click(function () {
        var registeraccount = $("#registeraccount").val();
        var registerpassword = $("#registerpassword").val();
        var user = {
            "registeraccount": registeraccount,
            "registerpassword": hex_md5(registerpassword)
        };

        if (registeraccount == "") {
            $(".msg").html("用户名不能为空");
            return;
        }
        if (registerpassword == "") {
            $(".msg").html("密码不能为空");
            return;
        }
        $.ajax({
                url: "/user/register",
                type: "POST",
                dataType: "json",
                contentType: "application/json",
                data: JSON.stringify(user),
                success: function (data) {
                    console.log("请求成功" + data.code + "," + data.msg)
                    if (data.code != 200) {
                        $(".msg").html(data.msg);
                    }
                    if (data.code == 200) {
                        alert("注册成功")
                        // window.sessionStorage.setItem("data", JSON.stringify(data));

                    }
                }
            }
        )

    })
})