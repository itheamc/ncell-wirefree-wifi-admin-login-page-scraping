from selenium import webdriver
from selenium.webdriver.support import expected_conditions as ec
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
import time

# specify the chrome driver path to use
driver = webdriver.Chrome('C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe')
driver.maximize_window()        # Maximizing the driver window to get the view larger
driver.get('http://192.168.0.1/')

# targeting the login button
time.sleep(1.5)
login_btn = WebDriverWait(driver, 10).until(ec.element_to_be_clickable((By.ID, 'loginlink')))
login_btn.click()

# target username
username = WebDriverWait(driver, 10).until(ec.element_to_be_clickable((By.CSS_SELECTOR, "input[name='txtUsr']")))
password = WebDriverWait(driver, 10).until(ec.element_to_be_clickable((By.CSS_SELECTOR, "input[name='txtPwd']")))

# enter username and password
time.sleep(2)
username.clear()
username.send_keys("admin")     # Enter Your username here
password.clear()
password.send_keys("admin")     # Enter your password here

# target the login button and click it
time.sleep(1.5)
button = WebDriverWait(driver, 5).until(ec.element_to_be_clickable((By.ID, 'btnLogin')))
button.click()

# targeting to setting div to see the connected devices
time.sleep(1.5)
div = WebDriverWait(driver, 10).until(ec.element_to_be_clickable((By.CSS_SELECTOR, "a[data-trans='device_setting']")))
div.click()

# Targeting to the DataUsagesSetting to see the usage statistics
usage_setting = WebDriverWait(driver, 10).until(ec.element_to_be_clickable((By.CSS_SELECTOR, "a[data-trans='statistics_settings']")))
usage_setting.click()
