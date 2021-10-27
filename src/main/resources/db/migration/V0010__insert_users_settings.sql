INSERT INTO users_settings (type, default_value, title, description, tech_name)
VALUES
('CHECKBOX', 'false', 'Отображать выполненные цели', 'Если настройка включена в списке целей будут продолжать отображаться уже выполненные цели, если отключена - только актуальные', 'DISPLAY_FINISH_GOAL'),
('TEXT', '#99ссff', 'Цвет сфер по-умолчанию', 'Цвет для сфер, если не выбран при создании', 'SPHERE_DEFAULT_COLOR'),
('TEXT', '#ff99ff', 'Цвет цели по-умолчанию', 'Цвет для цели, если не выбран при создании', 'GOAL_DEFAULT_COLOR');