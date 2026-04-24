# 🎮 ゲーム制作 タスク管理ボード

[![Java 21](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.5-6DB33F?logo=spring-boot&logoColor=white)](#)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)](#)
[![AWS RDS](https://img.shields.io/badge/AWS-RDS-FF9900?logo=amazonaws&logoColor=white)](#)

チームでのゲーム制作を支援するための、Webベースのタスク・工数管理アプリケーションです。

> ⚠️ **公開状況について**
> 本アプリケーションはAWS環境（EC2, RDS等）にてデプロイ・公開していましたが、現在はインフラ維持コストの観点から**クラウドリソースを停止し、非公開**としています。
> ソースコードおよびローカル環境での実行手順は本リポジトリにて公開しております。

## 💡 開発の背景と目的
ゲーム制作などの複雑なプロジェクトにおいて、「親タスク（例：キャラクター実装）」と「子タスク（例：モデリング、モーション、エフェクト）」の階層関係を可視化し、チーム全体の作業見積もりを正確に把握するために開発しました。

## ✨ 主な機能と技術的な工夫

* **ツリー構造によるタスクの階層管理**
  親タスク・子タスクの無制限のネスト（親子関係）をデータベース上で表現し、直感的なタスク分解を可能にしました。
* **再帰的アルゴリズムを用いた工数自動集計**
  `ProjectNodeService` にて、最下層のサブタスクに設定された見積もり工数を、親タスク・ルートプロジェクトへと**再帰的にさかのぼって自動計算するロジック**を実装しました。
* **RESTful APIの設計とSpring Bootの活用**
  フロントエンドとバックエンドを分離し、JSON形式でやり取りするモダンなAPIサーバーとして構築しています。
* **AWS RDSを用いたデータベース運用**
  ローカルのH2データベースでの開発を経て、本番環境ではAWS RDS (MySQL) へ接続して運用を行いました。環境変数でDB接続先を切り替える設計にしています。

## 🛠 技術スタック

| カテゴリ | 技術 |
|---------|------|
| バックエンド | Java 21, Spring Boot 3.3.5 |
| フロントエンド | HTML, JavaScript (Vanilla) |
| データベース | MySQL (AWS RDS) / H2 (開発用) |
| ORM | Spring Data JPA |
| テンプレート | Thymeleaf |
| ビルドツール | Maven |

## 📁 プロジェクト構成（主要部）
```text
src/main/java/com/example/demo/
├── controller/
│   ├── TaskController.java        # タスクCRUD用API
│   └── ProjectNodeController.java # 工数計算・ツリー構造API
├── entity/
│   ├── Task.java                  # タスク定義
│   └── ProjectNode.java           # 再帰的なツリー構造を表現するエンティティ
└── service/
    └── ProjectNodeService.java    # プロジェクト工数の再帰計算ロジック（コア機能）
```

---

## 🚀 ローカル環境でのセットアップ

### 前提条件
- Java 21 以上
- Maven 3.9 以上
- MySQL (または内蔵H2データベース)

### 1. リポジトリのクローン
```bash
git clone [https://github.com/TOMO0904/web-application.git](https://github.com/TOMO0904/web-application.git)
cd web-application
```

### 2. 環境変数の設定

`src/main/resources/application-local.properties.example` をコピーし、DB接続情報を設定します。
```bash
export RDS_URL=jdbc:mysql://localhost:3306/your_database
export RDS_USERNAME=your_username
export RDS_PASSWORD=your_password
```

### 3. アプリケーションの起動
```bash
./mvnw spring-boot:run
```

※テストデータ付きで起動する場合は、プロファイルを指定してください。
`./mvnw spring-boot:run -Dspring-boot.run.profiles=dev`

## 📝 API エンドポイント一例

* `GET /api/tasks` : タスク一覧取得
* `POST /api/tasks` : タスク作成
* `GET /api/projects/{id}/effort` : プロジェクトの総工数（再帰的集計結果）を取得
