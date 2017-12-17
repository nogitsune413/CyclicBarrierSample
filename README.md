# CyclicBarrierSample
CyclicBarrierのサンプルプログラムです。

## 概要
CyclicBarrierを使って同期を取りながら、ファイルバックアップを行います。

### ■ バックアップ対象
- 売上帳票
- 在庫帳票
- クーポン帳票

### ■ 機能
- バックアップ対象期間を指定できるようにします。
- 帳票は日付単位で、ひとつのアーカイブファイルに圧縮して保存します。

## 設計
対象期間の帳票に対して、以下の処理を実行します。
1. 同じ日付の帳票ファイルを、workフォルダにコピーします。
2. workフォルダに集めた同じ日付の帳票ファイルを圧縮し、アーカイブフォルダに保存します。

![image](https://user-images.githubusercontent.com/2310460/34079728-88b33a8c-e376-11e7-9093-bf3bbe979bcd.png)

### ■ CyclicBarrierの役割
この機能におけるCyclicBarrierの役割は以下です。

|機能                      　　|CyclicBarrierの役割　|
|:----------------------------|:-------------------|
| ファイルをWORKフォルダにコピー |スレッドの同期        |
| WORKフォルダのファイルの圧縮 |共通処理の実行          |

![3](https://user-images.githubusercontent.com/2310460/34079738-cd367656-e376-11e7-985c-7abd54467510.JPG)

### ■ フォルダ構成

フォルダの構成は以下です。

```text
C:
└─test
   ├─archive（圧縮した帳票の格納先フォルダ）
   │
   ├─config
   │      config.properties
   │      
   ├─dailyReport
   │  ├─coupon                   ← 帳票「クーポン」フォルダ
   │  │      coupon_20171001.csv
   │  │      coupon_20171002.csv
   │  │      coupon_20171003.csv
   │  │      
   │  ├─sales                    ← 帳票「売上」フォルダ
   │  │      sales_20171001.csv
   │  │      sales_20171002.csv
   │  │      sales_20171003.csv
   │  │      
   │  └─stock                    ← 帳票「在庫」フォルダ
   │          stock_20171001.csv
   │          stock_20171002.csv
   │          stock_20171003.csv
   │          
   └─work (帳票ファイルの一時格納先)
```

## 関連
このプログラムを使ったCyclicBarrierの解説記事を以下に書いています。<br/>
[Qiita記事 JavaのCyclicBarrierを使って平行処理を行う](https://qiita.com/nogitsune413/items/ec0132c306e1f15c6f87)
