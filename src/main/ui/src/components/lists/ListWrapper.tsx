import styled from "styled-components";

const ListsWrapper = styled.div`
  display: flex;
  align-items: center;
  width: 975px;
  padding-top: 25px;
  
  .MuiBox-root {
    max-height: 800px;
    
    .MuiPaper-root {
      max-height: 800px;
      border-radius: 30px;

      .MuiTableHead-root {
        position: sticky;
        top: 0;
        background-color: #5a0289;
        
        .MuiTableRow-head {
          border-bottom: 2px solid #5a0289;

          .MuiTableCell-head {
            font-weight: bold;
            text-align: center;
            font-size: 16px;
            color: white;
            border-bottom: 2px solid white;

            &:not(:last-child) {
              border-right: 2px solid white;
            }
          }
        }
      }

      .MuiTableBody-root {
        .MuiTableRow-root {
          .MuiTableCell-root {
            text-align: center;
            font-size: 16px;

            .actionIcon {
              &:hover {
                cursor: pointer;
              }
            }
          }
        }
      }
    } 
  }
`;

export default ListsWrapper;