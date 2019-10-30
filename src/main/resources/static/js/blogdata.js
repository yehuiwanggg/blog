$(document).ready(function () {


    var start = 0;
    var end = 10;
    var list = new Array();
    //第一次访问时加载
    getBlogs();

    function getBlogs() {

        var data = {
            'start': start,
            'end': end
        }
        start = start + end;
        // console.log(data)
        $.ajax({
            url: "/blog/getBlog",
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            success: function (data) {
                if (data == null) {
                    return false;
                }
                list = data.object;
                $.each(list, function (index, value) {

                    var content = value.content;
                    if (content.length > 100) {

                        content = content.substring(0, 100) + " ....";

                    }
                    var blog = $("#blog");
                    var b = "";
                    b += "        <div style='height: 50px;'>\n";
                    b += "          <div class='col-xs-12' style='height: 100px;width: 100%;'>\n";
                    b += "             <div class='col-xs-12' style='height: 30px;'><a href='#' style='color: #0f0f0f;'><h4 style='font-weight:bold '>" + value.title + "</h4></a></div>\n";
                    b += "               <div class='col-xs-12' style='height: 40px'>\n";
                    b += "               <a href='#' style='color: #6b6b6b;'>\n";
                    b += "                  <span>" + content + "</span>\n";
                    b += "               </a>\n";
                    b += "             </div>\n";
                    b += "             <div class='col-xs-12' style='height: 20px;'>\n";
                    b += "                <div class='col-xs-7'>\n";
                    b += "                    <span style='color: #8c8c8c'>" + value.userid + "</span>\n";
                    b += "                </div>\n";
                    b += "                <div class='col-xs-5'>\n";
                    b += "                   <a href='#' style='width: 80px' id='comment'>\n";
                    b += "                      <span class='glyphicon glyphicon-comment' style='color: #8c8c8c;'></span>" + value.commentnum + "条评论\n";
                    b += "                   </a>\n";
                    b += "                   <a href='#' style='width: 80px' id='read'>\n";
                    b += "                      <span class='glyphicon glyphicon-fire' style='color: #8c8c8c'></span>" + value.clicknum + "阅读\n";
                    b += "                   </a>\n";
                    b += "                   <a href='#' style='width: 80px' id='collection'>\n";
                    b += "                     <span class='glyphicon glyphicon-star' style='color: #8c8c8c'></span>收藏\n";
                    b += "                   </a>\n";
                    b += "                   <a href='#' style='width: 80px' id='agree'>\n";
                    b += "                     <span class='glyphicon glyphicon-star' style='color: #8c8c8c'></span>" + value.agreenum + "点赞\n";
                    b += "                   </a>\n";
                    b += "                </div>\n";
                    b += "             </div>\n";
                    b += "          </div>\n";
                    b += "     </div>\n";
                    blog.append(b)

                })

            },
            error: function (data) {
                console.log(data)
                var respones = data.responseJSON;

                var blog = $("#blog");
                var b = respones.status + respones.error + "\n获取文章列表 请刷新重试";
                blog.append(b);
            }
        })
    }

    $(document).scroll(function () {
        var $this = $(this);
        viewH = $(window).height();//可见高度
        contentH = $this.height();//内容高度
        scrollTop = $this.scrollTop();//滚动高度
        console.log(contentH, viewH, scrollTop)
        console.log(contentH - viewH - scrollTop)
        if (contentH - viewH - scrollTop <= 0) { //当滑动到底部时执行,

            if (list != null) {

                getBlogs()

            }
        }


    })//滚动刷新数据
})