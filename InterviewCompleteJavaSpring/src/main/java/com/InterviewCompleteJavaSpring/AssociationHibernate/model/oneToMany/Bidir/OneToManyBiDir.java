package com.InterviewCompleteJavaSpring.AssociationHibernate.model.oneToMany.Bidir;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "OneToManyBiDirEmployee")
public class OneToManyBiDir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    @OneToMany(mappedBy = "employeeBid",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OneToManyBiDirOwner> addressesBid;
    //afater we do jsonIgnor--> Object -> json by Jackson library
    /**
     * {
     *     "employeeId": 1010L,
     *     "employeeName": "e1Name",
     *     "addressBid": [
     *             "addressId": 14545L,
     *             "addressName": "addressName",
     *             "employeeBid":{
     *                  "employeeId": 1010L,
     *                  "employeeName": "e1Name",
     *                  "addressBid":[]
     *             },
     *             "addressId": 124545L,
     *      *             "addressName": "addressName2",
     *      *             "employeeBid":{
     *      *                  "employeeId": 1010L2,
     *      *                  "employeeName": "e1Name2",
     *      *                  "addressBid":[]
     *      *             }
     *
     *              ]
     *     }
     *
     *
     * }
     *
     */

}
