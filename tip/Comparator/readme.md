## 람다식
```java
books.sort((a,b)->Integer.parseInt(a.getIsbn())-Integer.parseInt(b.getIsbn()));
```
따로 comparator 나 comparable을 구현하지 않아도 람다식으로 사용가능
