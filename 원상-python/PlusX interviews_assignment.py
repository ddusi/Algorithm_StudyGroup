# 이분탐색 
# 다음과 같은 리스트가 주어졌을 때, 찾고자 하는 값을 찾으시오, 이때, 중복값일 시 가장 오른쪽 값의 인덱스를 반환하시오.

data = [1,4,5,6,7,7,8,10,16,17,18,18,22,22,22,34,55,58]
start, end = 0, len(data)
target = 22


def searching(target, data):
    start = 0
    end = len(data) - 1
    
    while start <= end:
        mid = (start + end) // 2
        
        if data[mid] == target:
            while data[mid] == target:
                mid += 1
            return mid - 1
        
        elif data[mid] < target:
            start = mid + 1
            
        else:
            end = mid - 1

print(searching(22, data))
