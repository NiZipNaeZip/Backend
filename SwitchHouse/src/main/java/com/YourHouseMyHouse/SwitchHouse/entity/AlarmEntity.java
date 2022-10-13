package com.YourHouseMyHouse.SwitchHouse.entity;

import com.YourHouseMyHouse.SwitchHouse.common.entity.AlarmStatus;
import com.YourHouseMyHouse.SwitchHouse.common.entity.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "Alarm")
public class AlarmEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alarmId;

    @Column(length = 20)
    private String startDate;

    @Column(length = 20)
    private String endDate;

    @Column(length = 255)
    private String comment;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private AlarmStatus alarmStatus = AlarmStatus.UNREAD;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private UserEntity receiver;

    public void acceptNotice() {
        this.alarmStatus = AlarmStatus.ACCEPT;
    }

    public void rejectNotice() {
        this.alarmStatus = AlarmStatus.REJECT;
    }
}