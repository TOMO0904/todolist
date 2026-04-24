# 🎮 ゲーム制作 タスク管理ボード

チームでのゲーム制作を支援するWebベースのタスク管理ツールです。  
タスクのツリー構造管理、メンバーアサイン、工数管理ができます。

## ✨ 機能一覧

| 機能 | 説明 |
|------|------|
| タスク管理 | タスクの作成・編集・削除・完了管理 |
| ツリー構造 | 親子関係を持つタスクの階層管理 |
| メンバー管理 | チームメンバーの登録・タスクへのアサイン |
| 工数管理 | タスクごとの見積もり工数の設定・子タスクの自動集計 |
| プロジェクト管理 | プロジェクト単位での工数管理（再帰的集計） |

## 🛠 技術スタック

| カテゴリ | 技術 |
|---------|------|
| バックエンド | Java 21, Spring Boot 3.3.5 |
| フロントエンド | HTML, JavaScript (Vanilla) |
| データベース | MySQL (AWS RDS) / H2 (開発用) |
| ORM | Spring Data JPA |
| テンプレート | Thymeleaf |
| ビルド | Maven |

## 📁 プロジェクト構成

```
src/main/java/com/example/demo/
├── DemoApplication.java          # アプリケーション起点
├── controller/
│   ├── TaskController.java       # タスクAPI（CRUD）
│   ├── MemberController.java     # メンバーAPI
│   └── ProjectNodeController.java # プロジェクト工数API
├── entity/
│   ├── Task.java                 # タスクエンティティ
│   ├── Member.java               # メンバーエンティティ
│   └── ProjectNode.java          # プロジェクトツリー（再帰構造）
├── repository/
│   ├── TaskRepository.java
│   ├── MemberRepository.java
│   └── ProjectNodeRepository.java
└── service/
    ├── ProjectNodeService.java   # プロジェクト工数の再帰計算
    └── DataLoader.java           # 開発用テストデータ
```

## 🚀 セットアップ

### 前提条件

- Java 21 以上
- Maven 3.9 以上
- MySQL（AWS RDS またはローカル）

### 1. リポジトリをクローン

```bash
git clone https://github.com/TOMO0904/web-application.git
cd web-application
```

### 2. 環境変数を設定

`src/main/resources/application-local.properties.example` を参考に、以下の環境変数を設定してください：

```bash
export RDS_URL=jdbc:mysql://localhost:3306/your_database
export RDS_USERNAME=your_username
export RDS_PASSWORD=your_password
```

### 3. アプリケーションを起動

```bash
./mvnw spring-boot:run
```

ブラウザで http://localhost:8080 にアクセスしてください。

### 開発用テストデータ

テストデータ付きで起動する場合：

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📝 API エンドポイント

| メソッド | エンドポイント | 説明 |
|---------|---------------|------|
| GET | `/api/tasks` | タスク一覧を取得 |
| POST | `/api/tasks` | タスクを作成 |
| PUT | `/api/tasks/{id}` | タスクを更新 |
| DELETE | `/api/tasks/{id}` | タスクを削除 |
| GET | `/api/members` | メンバー一覧を取得 |
| POST | `/api/members` | メンバーを登録 |
| GET | `/api/projects` | ルートプロジェクト一覧を取得 |
| POST | `/api/projects` | プロジェクトを作成 |
| GET | `/api/projects/{id}/effort` | プロジェクトの総工数を取得 |

## 📄 ライセンス

[MIT License](LICENSE)
