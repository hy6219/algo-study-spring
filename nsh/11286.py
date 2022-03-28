import heapq
from sys import stdin

N = int(stdin.readline())

X = []
for _ in range(N):
    i = int(stdin.readline())
    if i != 0:
        heapq.heappush(X, (abs(i), i))
    else:
        if len(X) > 0:
            result = heapq.heappop(X)
            print(result[1])
        else:
            print(0)