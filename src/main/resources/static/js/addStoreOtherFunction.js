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
    alert(indexArray);
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

function deleteTable(){
    var test = event.target;
    test.remove();
}