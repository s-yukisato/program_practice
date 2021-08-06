import numpy as np

n = int(input())
m = np.array([list(map(int,input().split())) for _ in range(n)])

row_sum, col_sum = np.sum(m, axis=1), np.sum(m, axis=0)
correct = max(row_sum)

idxs = np.where(m == 0)
for i, j in np.transpose(idxs):
    m[i][j] = correct - max(row_sum[i], col_sum[j])

[print(*a) for a in m]
