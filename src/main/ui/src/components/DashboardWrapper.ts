import styled from "styled-components";

const DashboardWrapper = styled.div`
      width: 100vw;
      height: 100%;
      min-height: 100vh;
      display: flex;
      align-items: center;
      flex-direction: column;
      font-family: "Nunito", sans-serif;
      background-image: linear-gradient(90deg, #5a0289, #00ffe3);
      
      &.loading {
        height: 100vh;
      }
      
      .resultsHeader {
            margin-top: 30px;
            display: flex;
            justify-content: center;
            color: white;
            width: 100%;
      }
`;

export default DashboardWrapper;