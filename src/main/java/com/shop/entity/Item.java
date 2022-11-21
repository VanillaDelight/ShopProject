package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 클래스를 엔티티로 선언
@Table(name = "item") // 엔티티와 매핑할 테이블을 지정

@Setter
@ToString
public class Item {

    @Id // 테이블의 기본키에 사용할 속성을 지정
    @Column(name = "item_id") // 필드와 컬럼 매핑
    @GeneratedValue(strategy = GenerationType.AUTO) // 키 값을 생성하는 전략 명시(AUTO 가 기본값 JPA 구현체가 자동으로 전략 결정)
    private Long id; // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm; // 상품명

    @Column(name = "price", nullable = false)
    private int price; // 가격

    @Column(nullable = false)
    private int stockNumber; // 재고수량

    // BLOB, CLOB 타입 매핑
    // B => 바이너리 데이터를 DB 외부에 저장하기 위함 (이미지, 사운드, 비디오 같은 멀티미디어 데이터)
    // C => 사이즈가 큰 데이터를 외부파일로 저장하기 위함 (문자형 대용량 파일)
    @Lob
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING) // enum 타입 매핑
    private ItemSellStatus itemSellStatus; // 상품 판매 상태

    private LocalDateTime regTime; // 등록시간

    private LocalDateTime updateTime; // 수정시간
}
