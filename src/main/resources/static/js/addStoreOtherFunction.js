function getIndexOfTable(){
    var indexArray=[];
    var indexPartArray=[]
    var index;
    for(index=0; index<document.getElementsByClassName('drag').length; index++){
        var target = document.getElementsByClassName('drag')[index];
        indexPartArray.push(target.id);
        indexPartArray.push(target.getBoundingClientRect().left);
        indexPartArray.push(target.getBoundingClientRect().top);
        indexArray.push(indexPartArray);
        indexPartArray=[];
    }
    return indexArray;
}

function plus()  {
    // 결과를 표시할 element
    const resultElement = document.getElementById('seat');

    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
    number = parseInt(number) + 1;

    // 결과 출력
    resultElement.innerText = number;
}

function getIndexOfTable(){
    var indexArray=[];
    var indexPartArray=[]
    var index;
    for(index=0; index<document.getElementsByClassName('drag').length; index++){
        var target = document.getElementsByClassName('drag')[index];
        indexPartArray.push(target.id);
        indexPartArray.push(target.getBoundingClientRect().left);
        indexPartArray.push(target.getBoundingClientRect().top);
        indexArray.push(indexPartArray);
        indexPartArray=[];
    }
    return indexArray;
}

function plus()  {
    // 결과를 표시할 element
    const resultElement = document.getElementById('seat');

    // 현재 화면에 표시된 값
    let number = resultElement.innerText;
    number = parseInt(number) + 1;

    // 결과 출력
    resultElement.innerText = number;
}

function dataPassing(){
    const resultElement = document.getElementById('seat');
    let seat = resultElement.innerText;
    var totalSeat = seat;
    var positionIndex = getIndexOfTable();
    var businessName = document.getElementById('businessName').value;
    var storeName = document.getElementById('storeName').value;
    var phone = document.getElementById('phone').value;
    var introduce = document.getElementById('textinput').value;
    var type = document.getElementById('type').value;
    var detailAddress = document.getElementById('detailAddress').value;
    var address = document.getElementById('address_kakao').value;

    $.ajax({
        url:"/addStore",
        type:'POST',
        traditional : true,
        data :{"totalSeat" : totalSeat, "positionIndex" : positionIndex, "businessName" : businessName,
        "storeName" : storeName, "phone" : phone, "introduce" : introduce, "type" : type, "address" : address
        , "detailAddress" : detailAddress},
        success:function(data){
            alert("가게 등록이 완료되었습니다!");
        },
        error:function(jqXHR, textStatus, errorThrown){
            alert("ajax를 통한 데이터패싱의 에러");
        }
    });
}

