function getIndexOfTable(){
    var indexArray=[];
    var indexPartArray=[]
    var index;
    for(index=0; index<document.getElementsByClassName('drag').length; index++){
        var target = document.getElementsByClassName('drag')[index];
        indexPartArray.push(window.getComputedStyle(target).getPropertyValue('top'));
        indexPartArray.push(window.getComputedStyle(target).getPropertyValue('left'));
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

    $.ajax({
            url:"/addStore",
            type:'POST',
            traditional : true,
            data :{"totalSeat" : totalSeat, "positionIndex" : positionIndex},
            success:function(data){
                alert("완료!");
            },
            error:function(jqXHR, textStatus, errorThrown){
                alert("ajax를 통한 데이터패싱의 에러");
            }
        });
}

