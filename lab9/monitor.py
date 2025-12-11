"""
Модуль, що містить базовий клас Monitor.
"""
class Monitor:
    """
    Базовий клас, що представляє монітор з основними характеристиками.
    """
    def __init__(self, brand, resolution_width, resolution_height):
        # Приватні поля (використання __ для імітації приватності)
        self.__brand = brand
        self.__width = resolution_width
        self.__height = resolution_height
        self._is_on = False  # Захищене поле
        
    def power_on(self):
        """Вмикає монітор."""
        self._is_on = True
        print(f"{self.__brand} монітор увімкнено.")

    def power_off(self):
        """Вимикає монітор."""
        self._is_on = False
        print(f"{self.__brand} монітор вимкнено.")

    def display_info(self):
        """Виводить основну інформацію про монітор."""
        status = "Увімкнено" if self._is_on else "Вимкнено"
        print(f"--- Інформація про Монітор ---")
        print(f"  Виробник: {self.__brand}")
        print(f"  Роздільна здатність: {self.__width}x{self.__height}")
        print(f"  Статус живлення: {status}")
        
    def get_resolution(self):
        """Повертає роздільну здатність як кортеж."""
        return (self.__width, self.__height)