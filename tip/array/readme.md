## Array.copyOfRange(array1, start, end)
배열을 범위만큼 복사한다. 디버깅해보니 start<= i <end 다. start포함 end 미포함  
```
int [] arr1 = new int [5];
arr1 ... 0 1 2 3 4 

arr2 = Array.copyOfRange(arr1,3,5);
arr2 ... 3 4
```
## Array.copyOf(array1, size)
배열을 크기만큼 복사한다. 
```
int [] arr1 = new int [5];
arr1 ... 0 1 2 3 4

arr2 = Array.copyOf(arr1,3);
arr2 ... 0 1 2
```

## 배열 삭제시 순서가 상관없는경우
```
0 1 2 3 4 n n //size=5
0 1 4 3 2 n n //2를 삭제하기 위해 맨뒤 값과 자리바꿈
0 1 4 3 n n n //순서는 바뀌었지만 2 삭제완료! index를 한개씩 당겨올 필요없음

	public void delete(int num) {
		for(int i=0; i<size; ++i){
			if(products[i].getNum()==num) {
				products[i]=products[size-1];
				products[--size]=null;
				return;
			}
		}
	}
```
