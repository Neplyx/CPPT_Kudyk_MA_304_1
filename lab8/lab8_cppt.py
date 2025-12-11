import sys
import math
import struct
import os

TEXT_FILE_NAME = "result_v11.txt"
BIN_FILE_NAME = "result_v11.bin"

def calculate(x):
    try:
        tan_x = math.tan(x)
        if tan_x == 0:
            raise ValueError("Знаменник (tg(x)) дорівнює нулю або x кратне π/2.")
            
        cot_x = 1.0 / tan_x
        y = cot_x / tan_x
        
        return y
        
    except ZeroDivisionError:
        raise ValueError("Ділення на нуль у виразі: tg(x) або ctg(x) не визначені.")
    except ValueError as e:
        raise ValueError(f"Обчислення неможливе: {e}")


def write_res_txt(f_name, result):
    with open(f_name, 'w', encoding="utf-8") as f:
        f.write(str(result))


def read_res_txt(f_name):
    if not os.path.exists(f_name):
        raise FileNotFoundError(f"Файл {f_name} не знайдено.")
        
    with open(f_name, 'r', encoding="utf-8") as f:
        result_str = f.read()
        return float(result_str)


def write_res_bin(f_name, result):
    with open(f_name, 'wb') as f:
        packed_data = struct.pack('f', result)
        f.write(packed_data)


def read_res_bin(f_name):
    if not os.path.exists(f_name):
        raise FileNotFoundError(f"Файл {f_name} не знайдено.")
        
    with open(f_name, 'rb') as f:
        data_size = struct.calcsize('f')
        packed_data = f.read(data_size) 
        
        if not packed_data or len(packed_data) < data_size:
            raise EOFError(f"Помилка читання: недостатньо даних у {f_name}.")
            
        result = struct.unpack('f', packed_data)[0]
        return result


if __name__ == "__main__":
    print("Програма для обчислення y = ctg(x) / tg(x) та роботи з файлами.")
    
    try:
        x_input = input("Введіть значення x (у радіанах): ")
        x = float(x_input)
        
        result = calculate(x)
        print(f"\nРезультат обчислення y = ctg({x}) / tg({x}) = {result}")

    except ValueError as e:
        print(f"\nКритична помилка: {e}")
        sys.exit(1)
        
    try:
        write_res_txt(TEXT_FILE_NAME, result)
        print(f"   -> Результат успішно записано у текстовий файл: {TEXT_FILE_NAME}")
        
        read_txt = read_res_txt(TEXT_FILE_NAME)
        print(f"   <- Зчитаний результат з текстового файлу: {read_txt}")
        
        write_res_bin(BIN_FILE_NAME, result)
        print(f"   -> Результат успішно записано у двійковий файл: {BIN_FILE_NAME}")
        
        read_bin = read_res_bin(BIN_FILE_NAME)
        print(f"   <- Зчитаний результат з двійкового файлу: {read_bin}")
        
    except FileNotFoundError as e:
        print(f"\nПомилка файлової системи: {e}")
        sys.exit(1)
    except Exception as err:
        print(f"\nНеочікувана помилка: {repr(err)}")
        sys.exit(1)