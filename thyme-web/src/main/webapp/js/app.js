var thymeModule = (function (){

    return {
        submitAjaxForm: function() {
            var url = window.location.href + "/form-submit";
            var posting = $.post(url, $("#ajaxForm").serialize());
            posting.success(function(data) {
                $("#ajaxForm").hide();
                $("#ajaxBlock").html(data);
            });
        }
    };
})();