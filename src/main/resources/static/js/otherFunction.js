function getInformationOfTable(){
    var indexArray=[];
    var indexPartArray=[]
    var index;
    var height = event.target.getAttribute('height');
    var width = event.target.getAttribute('width');
    for(index=0; index<document.getElementsByClassName('table').length; index++){
        var target = document.getElementsByClassName('table')[index];
        indexPartArray.push(target.id);
        indexPartArray.push(target.getBoundingClientRect().left.toFixed());
        indexPartArray.push(target.getBoundingClientRect().top.toFixed());
        if(target.getAttribute('height')==height && target.getAttribute('width')==width){
            indexPartArray.push(1);
        }
        else{
            indexPartArray.push(0);
        }
        indexArray.push(indexPartArray);
        indexPartArray=[];
    }
    return indexArray;
}

function changeFlag(){

    var positionIndex = getInformationOfTable();
    var businessName = document.getElementById('businessName');
    var storeName = document.getElementById('storeName');
    var phone = document.getElementById('phone').value;
    var introduce = document.getElementById('introduce').value;
    var type = document.getElementById('type').value;
    var detailAddress = document.getElementById('detailAddress').value;
    var address = document.getElementById('address').value
    var totalSeat = document.getElementById('totalSeat').value;
    var phone = [[${phone}]];
    alert(phone);

    $.ajax({
            url:'/viewStore',
            type:'POST',
            traditional : true,
            data :{"totalSeat" : totalSeat, "positionIndex" : positionIndex, "businessName" : businessName,
                    "storeName" : storeName, "phone" : phone, "introduce" : introduce, "type" : type, "address" : address
                    , "detailAddress" : detailAddress, "id" : id},
            success:function(data){
                alert("빈 자리가 찬 자리로 바꼈습니다.");
            },
            error:function(jqXHR, textStatus, errorThrown){
                alert("에러!");
            }
        });

}
