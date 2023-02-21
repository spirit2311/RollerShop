import styled from "styled-components";

const SkatesListWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 100px 20px;
  margin-top: 25px;
  margin-bottom: 100px;

  .CardWrapper {
    border-radius: 30px;

    .CardContent {
      display: flex;
      flex-direction: column;
      justify-content: space-between;

      div {
        display: -webkit-box;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
        width: 210px;
        overflow: hidden;
      }
      
      .overviewContent {
        .title {
          font-size: 26px;
        }
        .content {
           -webkit-line-clamp: 11;
        }
      }
      
      .actions {
        display: flex;
        justify-content: space-around;
        margin-top: 15px;

        .actionIcon {
          border-radius: 30px;
          height: 50px;
          width: 50px;
          display: flex;
          justify-content: center;
          align-items: center;
          
          &:hover {
            background: #D3D3D3;
            cursor: pointer;
          }
        }
      }

      .secondaryText {
        display: flex;
        flex-direction: row;

        .priceAndReleaseDate {
          font-size: 16px;
        }
      }
    }
  }
  
  .EditSkateDialogContainer {
    border-radius: 30px;
  }
`;

export default SkatesListWrapper;