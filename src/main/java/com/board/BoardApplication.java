package com.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 자동 설정 + 컴포넌트 스캔 (com.board 하위 패키지 전체)
// 自動設定 + コンポーネントスキャン（com.board 以下のパッケージ全体）
public class BoardApplication {

	// 애플리케이션 시작점: 내장 Tomcat 실행 + yml 읽기 + 커넥션 풀/MyBatis 자동 연결
	// アプリケーションの開始点：組み込みTomcatを起動 + ymlを読み込み + コネクションプール/MyBatisを自動接続
	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}
}
