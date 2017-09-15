var clients = [];
$(function () {
    clients = $.clientsInit();
})
$.clientsInit = function () {
    var dataJson = {
        dataItems: [],
        organize: [],
        role: [],
        duty: [],
        user: [],
        damItems: [],
        projectNameItems: []
    };
    var init = function () {
        $.ajax({
            url: "/Tool/GetMobileClientsDataJson",
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                dataJson.dataItems = data.dataItems;
                dataJson.organize = data.organize;
                dataJson.role = data.role;
                dataJson.duty = data.duty;
                dataJson.username = data.user;
                dataJson.damItems = data.damItems;
                dataJson.projectNameItems = data.projectNameItems;
            }
        });
    }
    init();
    return dataJson;
}