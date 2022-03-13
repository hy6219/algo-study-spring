from re import T
import sys
input = sys.stdin.readline

n = int(input())

t = []
for _ in range(0, n):
    t.append(list(map(int, input().split())))

t.sort(key=lambda x : x[1], reverse=True)

duration = t[0][1] - t[0][0] + 1

for i in range(1, len(t)):
    if t[i][1] >= duration:
        duration = t[i][1] - t[i][0] - (t[i][1] - duration)
    else:
        duration = t[i][1] - t[i][0] + 1

print(duration -1)