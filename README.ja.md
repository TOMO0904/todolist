[English](README.md) | **日本語**

# ゲーム制作タスクボード（Spring Boot）

[![Java 21](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.5-6DB33F?logo=spring-boot&logoColor=white)](#)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)](#)
[![AWS RDS](https://img.shields.io/badge/AWS-RDS-FF9900?logo=amazonaws&logoColor=white)](#)

チームでのゲーム制作向けの、Webベースのタスク・工数管理バックエンドです。

> **公開状況:** 以前はAWS（EC2 / RDS）で公開していました。費用を抑えるためにクラウドのリソースは停止しており、動くデモはありません。ソースコードとローカルでの実行手順はこちらにあります。

## 課題

ゲーム制作のようなプロジェクトでは、親タスク（「キャラクターを実装する」）が子タスク（モデリング、モーション、エフェクト）に分かれていきます。平らなToDoリストでは、階層全体と正確な合計見積もりを把握するのが難しくなります。

## 解決方法

- **ツリー構造のタスク:** 親子関係を何階層でもデータベースに保存できます。
- **工数の再帰的な集計:** `ProjectNodeService` が、末端のサブタスクの見積もりを親へ順にさかのぼって、ルートのプロジェクトまで合計します。
- **REST API** でJSONを返し、軽量なHTML/JavaScriptのフロントエンドは別に用意しています。
- **データベースの切り替え:** ローカル開発ではH2、本番ではAWS RDS上のMySQLを、環境変数で選びます。

エンドポイントの例: `GET /api/tasks`、`POST /api/tasks`、`GET /api/projects/{id}/effort`

## 技術スタック

Java 21 · Spring Boot 3.3.5 · Spring Data JPA · Thymeleaf · MySQL（AWS RDS）/ H2 · Maven · JavaScript（フレームワークなし）

## ローカルで実行する

```bash
./mvnw spring-boot:run
```

MySQLを使う場合は、`src/main/resources/application-local.properties.example` を `application-local.properties` にコピーし、自分の接続情報を記入してください（このファイルはコミットしないでください）。

より詳しい日本語の説明は [docs/DETAILS.ja.md](docs/DETAILS.ja.md) にあります。
