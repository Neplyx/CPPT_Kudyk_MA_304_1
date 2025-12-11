"""
Точка входу в програму. Демонструє роботу класів Monitor та TouchScreen.
"""
# Імпортуємо похідний клас з пакета
from .touchscreen import TouchScreen

# Створення та демонстрація об'єкту
if __name__ == "__main__":
    
    # Створення об'єкта похідного класу (Сенсорний екран)
    my_touchscreen = TouchScreen(
        brand="Dell",
        resolution_width=1920,
        resolution_height=1080,
        multitouch_support=True
    )

    print("--- 1. Початкова інформація та увімкнення ---")
    my_touchscreen.display_info()
    my_touchscreen.power_on()  # Виклик перевизначеного методу
    
    print("\n--- 2. Обробка торкань ---")
    my_touchscreen.handle_touch_event(x=100, y=500)
    my_touchscreen.handle_touch_event(x=2000, y=500) # Торкання поза межами
    
    print("\n--- 3. Фінальна інформація та вимкнення ---")
    my_touchscreen.display_info()
    my_touchscreen.power_off()
    
    # Спроба торкання після вимкнення
    my_touchscreen.handle_touch_event(x=50, y=50)