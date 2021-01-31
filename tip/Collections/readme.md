# List
데이터를 인덱스를 통해 연속적으로 저장하기 위해 사용
### size
### add
### get
### remove
# Set
중복된 데이터를 저장(집합)
### add(value)
```
add(a) ... a
add(b) ... a b
add(c) ... a b c
add(a) ... a b c
```
### size
### remove(key)
# Map
key, value로 이루어져 있고 key를 통해 value에 접근
### size
### put(key, value)
이미 존재하는 key인 경우 value가 덮어씌워짐.
```
put(1,10) ... (1,10) 
put(2,20) ... (1,10) (2,20)
put(1,30) ... (1,30) (2,20)
```
### containsKey(key)
키가 있는지 확인. boolean 리턴
### keySet()
key들을 set으로 리턴.
### values()
collection으로 value 리턴.
### remove(key)
### get(key)
