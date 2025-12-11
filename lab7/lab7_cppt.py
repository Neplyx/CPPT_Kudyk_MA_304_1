import sys

try:
    N = int(input("Введіть розмір квадратної матриці (N): "))
except ValueError:
    print("Помилка: Розмір матриці має бути цілим числом.")
    sys.exit(1)

filler = input("Введіть символ-заповнювач (один символ): ")

if len(filler) != 1:
    if len(filler) == 0:
        print("Не введено символ-заповнювач.")
    else:
        print("Забагато символів-заповнювачів (потрібен лише один).")
    sys.exit(1)

jagged_list = []
mid_point = N // 2

for i in range(N):
    current_row = []
    for j in range(N):

        is_top_right = (i < mid_point) and (j >= mid_point)
        is_bottom_left = (i >= mid_point) and (j < mid_point)

        if is_top_right:
            current_row.append(filler)
        elif is_bottom_left:
            current_row.append("#")
        else:
            current_row.append(" ")

    jagged_list.append(current_row)

print("\n--- Сформований зубчатий список ---")
for row in jagged_list:
    print(" ".join(row))
