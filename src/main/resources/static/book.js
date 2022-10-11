function loadContent(url) {
    // url = "/ems" + url;
    if (url.indexOf("?") >= 0)
        url = url + "&";
    else
        url = url + "?";
    url = url + "tss=" + new Date().getTime();
    // UpdatePath(url);
    console.log("Loading Content from " + url);
    $.get(url, function (data) {
        $('#content').html(data);
    });
}