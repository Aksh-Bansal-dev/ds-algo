arr = [2,2,2,2,2]

start = 0
end = len(arr)-1

while start<=end:
    mid = int(start+(end-start)/2)
    if arr[mid]<2:
        start = mid+1
    else:
        end = mid-1

print("1st occurance of 2: ", start)

start = 0
end = len(arr)-1
while start<=end:
    mid = int(start+(end-start)/2)
    if arr[mid]<=2:
        start = mid+1
    else:
        end = mid-1

print("last occurance of 2: ", end)
