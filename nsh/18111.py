N, M, B = list(map(int, input().split()))

ground = []
c = {}

for _ in range(N):
    blocks = list(map(int, input().split()))
    for b in blocks:
        if c.get(b) != None:
            c[b] += 1
        else:
            c[b] = 1
    ground.append(blocks)

if B > 0:
    c = sorted(c.items(), key=lambda item: item[1], reverse=True)

    standard = c[0]
    for i in c:
        if i[1] == standard[1]:
            if (i[0] > standard[0]):
                standard = i
        else:
            break

    time = 0
    for i in range(len(ground)):
        for j in range(len(ground[i])):
            if ground[i][j] == standard[0]:
                continue
            elif ground[i][j] > standard[0]:
                if ground[i][j] > 0 and B > 0:
                    time += 2
                    ground[i][j] -= 1
            else:
                if ground[i][j] < 256:
                    time += 1
                    ground[i][j] += 1
                    B -= 1

else:
    c = sorted(c.items(), key=lambda item: item[1])

    standard = c[0]

    time = 0
    for i in range(len(ground)):
        for j in range(len(ground[i])):
            if ground[i][j] == standard[0] or ground[i][j] < standard[0]:
                continue
            elif ground[i][j] > standard[0]:
                if ground[i][j] > 0:
                    time += 2
                    ground[i][j] -= 1


print(time, max(map(max, ground)))

