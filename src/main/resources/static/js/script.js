

$(function( $ ){
    $("#calculateTax").on('submit', function(event){
        event.preventDefault();
        var age = $(this).find("#age").val();
        var income = $(this).find("#income").val();
        var exemptionAmount = $(this).find("#taxExemption").val();

        var payload = {
            age: age,
            income: income,
            taxExemptionAmount: exemptionAmount
        }

        getTax(
            JSON.stringify(payload),
            successCallback,
            failureCallback
        )

        function successCallback(data) {
            $(".report .old-tax").text(data.oldRegimeTax);
            $(".report .new-tax").text(data.newRegimeTax);
            $(".report .suggestion").text(data.suggestion);
            $(".report").show();
            $(".err-message").hide();
        }

        function failureCallback(data) {
            $(".report").hide();
            $(".err-message").show();
        }
    })
})

function getTax(payload, successCallback, failureCallback) {
    $.ajax({
        method: 'post',
        url: '/tax/calc',
        data: payload,
        contentType: 'application/json',
        dataType: 'json',
        success: function(response) {
            successCallback(response)
        },
        error: function(error) {
            failureCallback(error)
        }
    })
}