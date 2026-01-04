#!/usr/bin/env python3
import yfinance as yf
import time
import subprocess
import datetime

def get_financial_data():
    data = []
    """
    get finance data
    """
    tickers = {
        'USDJPY': 'JPY=X',
        'S&P500': '^GSPC',
        'NASDAQ': '^IXIC', 
        'Nikkei': '^N225',
        'US10Y' : '^TNX',
        'US05Y' : '^FVX',
        'US Gold' : 'GC=F',
        'BTC-US': 'BTC-USD', 
        'ETH-US': 'ETH-USD'
    }

    print("getting data...\n")

    now = datetime.datetime.now()
    # よく使われるフォーマット
    data0 = now.strftime("%Y%m%d")
    data1 = now.strftime("%H:%M:%S")
    data2 = f"{data0}:{data1}"
    data.append(data2)  

    for name, ticker in tickers.items():
        try:
            stock_info = yf.Ticker(ticker)
            data1 = stock_info.history(period="1d")
            if not data1.empty:
                current_value = data1['Close'].iloc[-1]
                if current_value < 999:
                #    print(f"{name}:{current_value:,.2f}")
                    data2 = f"{name}:{current_value:,.2f}"
                else:
                #    print(f"{name}:{int(current_value):,}")
                    data2 = f"{name}:{int(current_value):,}"
                data.append(data2)  
            else:
                data.append(f"{name}:No Data")
            #    print(f"{name}: no data")
        except Exception as e:
            print(f"{name}: error - {e}")
        time.sleep(2)
    return  data

def send_message(message):
    p = subprocess.Popen(['/usr/bin/aqm0802'], stdin=subprocess.PIPE)
    p.communicate(input=message.encode())

if __name__ == "__main__":
    financial_data = get_financial_data()
#    financial_data = "S&P500:6443,USDJPY:148.66,Nikkei:41938,US10Y:4.03,US02Y:3.74,US Gold:3621,BTC-US:111495,ETH-US:4382" #test data
    print(financial_data)
#    send_message(financial_data)
    str_data = ";".join(str(x) for x in financial_data)
    str_data = str_data + ';'
    send_message(str_data)
