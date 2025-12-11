"""
Модуль, що містить похідний клас TouchScreen.
"""
# Імпортуємо базовий клас з того ж пакета
from .monitor import Monitor

class TouchScreen(Monitor):
    """
    Похідний клас, що представляє сенсорний екран.
    Успадковує функціонал Monitor та додає функціонал сенсорного введення.
    """
    def __init__(self, brand, resolution_width, resolution_height, multitouch_support):
        # Виклик конструктора базового класу (Monitor)
        super().__init__(brand, resolution_width, resolution_height)
        # Додаткові поля похідного класу
        self.__multitouch = multitouch_support
        self.touch_active = False

    def power_on(self):
        """Перевизначений метод: вмикає монітор і активує сенсор."""
        super().power_on()
        self.touch_active = True
        print("Сенсорний інтерфейс активовано.")

    def power_off(self):
        """Перевизначений метод: вимикає монітор і деактивує сенсор."""
        self.touch_active = False
        print("Сенсорний інтерфейс деактивовано.")
        super().power_off()

    def handle_touch_event(self, x, y):
        """Імітує обробку торкання."""
        if self._is_on and self.touch_active:
            width, height = self.get_resolution()
            if 0 <= x < width and 0 <= y < height:
                print(f"Торкання оброблено у координатах ({x}, {y}).")
            else:
                print("Торкання поза межами екрана.")
        else:
            print("Сенсорний екран вимкнений або неактивний.")

    def display_info(self):
        """Перевизначений метод: виводить повну інформацію, включаючи підтримку мультитачу."""
        # Виклик методу базового класу для виведення основної інформації
        super().display_info()
        multitouch_status = "Підтримується" if self.__multitouch else "Не підтримується"
        print(f"  Підтримка Multitouch: {multitouch_status}")
        print(f"  Сенсорний інтерфейс: {'Активний' if self.touch_active else 'Неактивний'}")