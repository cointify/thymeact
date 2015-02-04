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
                    //$("#ajaxForm").hide();
                    $("#formBlock").html(data);
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