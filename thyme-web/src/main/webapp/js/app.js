var thymeModule = (function (){
    var url = window.location.origin + "/thymeweb";

    return {
        ajaxFormSubmit: function() {
            $.post(url + "/ajax-form-submit", $("#ajaxForm").serialize())
                .success(function(data) {
                    $("#ajaxForm").hide();
                    $("#ajaxBlock").html(data);
                });
        },
        ajaxFormValidation: function() {
            $.post(url + "/ajax-form-validation", $("#form").serialize())
                .success(function(data) {
                    $("#formBlock").html(data);
                });
        },
        ajaxUsernameValidation: function(username) {
            $.post(url + "/ajax-field-validation", { username: username })
                .success(function(data) {
                    $("#username-glyphicon").removeClass();
                    if(data === true) {
                        $("#username-glyphicon").addClass("glyphicon form-control-feedback glyphicon-ok");
                    } else {
                        $("#username-glyphicon").addClass("glyphicon form-control-feedback glyphicon-remove");
                    }
                });
        },
        poll: function() {
            setInterval(function() {
                $.ajax({
                    url: url + "/notifications",
                    type: "GET",
                    data: {
                        counter: parseInt($("#totalNotifications").text())
                    },
                    success: function(data) {
                        $("#totalNotifications").html(data);
                    }
                });
            }, 2000);

        }
    };
})();

// Start polling
thymeModule.poll();