;$(function () {
    getMessage();
    msgTask();
});
function getMessage() {
    $.getJSON("/UCenter/GetMessage", function (data) {
        if (data.num > 0) {
            $("#message").text(data.num);
            $("#message").show();
        } else {
            $("#message").text('');
            $("#message").hide();
        }
    });
}
//播放告警音
function AudioPerform() {
    var ua = navigator.userAgent.toLowerCase();
    var audiopath = "/content/wav/message.wav";
    if (ua.match(/msie ([\d.]+)/)) {
        jQuery('#ringbell').html('<object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95"><param name="AutoStart" value="1" /><param name="Src" value="' + audiopath + '" /><param name="Loop" value="-1">  </object>');
    }
    else if (ua.match(/firefox\/([\d.]+)/)) {
        jQuery('#ringbell').html('<audio autoplay="autoplay" loop="false"><source src="' + audiopath + '" type="audio/wav"/><source src="' + audiopath + '" type="audio/mpeg"/></audio>');
    }
    else if (ua.match(/chrome\/([\d.]+)/)) {
        jQuery('#ringbell').html('<audio src="' + audiopath + '" type="audio/wav" autoplay="autoplay" hidden="true" loop="false"></audio>');
    }
    else if (ua.match(/opera.([\d.]+)/)) {
        jQuery('#ringbell').html('<embed src="' + audiopath + '" hidden="true" loop="false"><noembed><bgsounds src=' + audiopath + '></noembed>');
    }
    else if (ua.match(/version\/([\d.]+).*safari/)) {
        jQuery('#ringbell').html('<audio src="' + audiopath + '" type="audio/wav" autoplay="autoplay" hidden="true" loop="false"></audio>');
    }
    else {
        jQuery('#ringbell').html('<embed src="' + audiopath + '" type="audio/wav" hidden="true" loop="false" mastersound></embed>');
    }
}
//获取告警数量
function getRing() {
    jQuery('#ringbell').html('');
    $.getJSON("/UCenter/GetMessageRing", function (data) {
        if (data.Result) {
            AudioPerform();
            getMessage();
        }
    });
}
//信息任务
function msgTask() {
    getRing();
    setTimeout(msgTask, 1000 * 30);
}
